/* This file is part of VoltDB.
 * Copyright (C) 2008-2010 VoltDB L.L.C.
 *
 * VoltDB is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VoltDB is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.voltdb.plannodes;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONStringer;

import org.voltdb.VoltType;
import org.voltdb.catalog.CatalogMap;
import org.voltdb.catalog.Column;
import org.voltdb.catalog.Database;
import org.voltdb.expressions.TupleValueExpression;
import org.voltdb.planner.PlanColumn;
import org.voltdb.planner.PlannerContext;
import org.voltdb.planner.PlanColumn.SortOrder;
import org.voltdb.planner.PlanColumn.Storage;
import org.voltdb.utils.CatalogUtil;

public abstract class AbstractOperationPlanNode extends AbstractPlanNode {

    public enum Members {
        TARGET_TABLE_NAME;
    }

    // The target table is the table that the plannode wants to perform some operation on.
    protected String m_targetTableName = "";

    protected AbstractOperationPlanNode(PlannerContext context) {
        super(context);
    }

    protected String debugInfo(String spacer) {
        return spacer + "TargetTableName[" + m_targetTableName + "]\n";
    }

    @Override
    public void validate() throws Exception {
        super.validate();

        // All Operation nodes need to have a target table
        if (m_targetTableName == null) {
            throw new Exception("ERROR: The Target TableId is null for PlanNode '" + this + "'");
        }
    }

    /**
     * @return the target_table_name
     */
    public final String getTargetTableName() {
        return m_targetTableName;
    }

    /**
     * @param target_table_name the target_table_name to set
     */
    public final void setTargetTableName(final String target_table_name) {
        m_targetTableName = target_table_name;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayList<Integer> createOutputColumns(Database db, ArrayList<Integer> input) {
        if (m_outputColumns.isEmpty())
        {
            // must produce a tuple value expression for this column.
            TupleValueExpression tve = new TupleValueExpression();
            tve.setValueType(VoltType.BIGINT);
            tve.setValueSize(VoltType.BIGINT.getLengthInBytesForFixedTypes());
            tve.setColumnIndex(0);
            tve.setTableName("VOLT_TEMP_TABLE");
            tve.setColumnAlias("modified_tuples");
            tve.setColumnName("modified_tuples");

            m_outputColumns.add(m_context.getPlanColumn(tve,
                                                        "modified_tuples",
                                                        SortOrder.kUnsorted,
                                                        Storage.kTemporary).guid());
        }
        return (ArrayList<Integer>)m_outputColumns.clone();
    }

    @Override
    public void toJSONString(JSONStringer stringer) throws JSONException {
        super.toJSONString(stringer);
        stringer.key(Members.TARGET_TABLE_NAME.name()).value(m_targetTableName);
    }
}
