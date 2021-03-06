/* This file is part of VoltDB.
 * Copyright (C) 2008-2017 VoltDB Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.voltdb.compiler;

import org.voltdb.client.ProcedureInvocationType;

public class CatalogChangeResult extends AsyncCompilerResult {
    private static final long serialVersionUID = 5065393610771307485L;

    public byte[] catalogHash;
    public byte[] catalogBytes;
    public String deploymentString;
    public String encodedDiffCommands;
    public int diffCommandsLength;
    public String[] tablesThatMustBeEmpty;
    public String[] reasonsForEmptyTables;
    public boolean requiresSnapshotIsolation;
    public boolean worksWithElastic;
    public ProcedureInvocationType invocationType;
    public long originalTxnId;
    public long originalUniqueId;
    // null or source version string if an automatic upgrade was done.
    public String upgradedFromVersion;
    public byte[] deploymentHash;
    public boolean isForReplay;
    public long replayTxnId;
    public long replayUniqueId;

    // Should catalog diff commands apply to EE or not
    public boolean requireCatalogDiffCmdsApplyToEE;
    // mark it false for UpdateClasses, in future may be marked false for deployment changes
    public boolean hasSchemaChange;
    // This is set to true if schema change involves stream or connector changes or a view on stream is created or dropped.
    public boolean requiresNewExportGeneration;
}
