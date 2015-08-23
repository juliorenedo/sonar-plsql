/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package br.com.felipezorzo.sonar.plsql.api.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class OpenForStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.OPEN_FOR_STATEMENT);
    }
    
    @Test
    public void matchesSimpleOpen() {
        assertThat(p).matches("open cur for myquery;");
    }
    
    @Test
    public void matchesOpenForSelectExpression() {
        assertThat(p).matches("open cur for select 1 from dual;");
    }
    
    @Test
    public void matchesOpenForHostCursor() {
        assertThat(p).matches("open :cur for myquery;");
    }
    
    @Test
    public void matchesOpenWithUsingClause() {
        assertThat(p).matches("open cur for myquery using foo;");
    }
    
    @Test
    public void matchesOpenWithInParameterInUsingClause() {
        assertThat(p).matches("open cur for myquery using in foo;");
    }
    
    @Test
    public void matchesOpenWithInParameterInOutUsingClause() {
        assertThat(p).matches("open cur for myquery using in out foo;");
    }
    
    @Test
    public void matchesOpenWithInParameterOutUsingClause() {
        assertThat(p).matches("open cur for myquery using out foo;");
    }
    
    @Test
    public void matchesOpenWithMultipleParameters() {
        assertThat(p).matches("open cur for myquery using foo, bar, baz;");
    }
    
    @Test
    public void matcheslabeledOpen() {
        assertThat(p).matches("<<foo>> open cur for myquery;");
    }

}