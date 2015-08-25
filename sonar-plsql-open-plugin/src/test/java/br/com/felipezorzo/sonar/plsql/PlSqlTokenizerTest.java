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
package br.com.felipezorzo.sonar.plsql;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.PlSqlTokenizer;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.TokenEntry;
import net.sourceforge.pmd.cpd.Tokens;

public class PlSqlTokenizerTest {

    @Test
    public void shouldWorkOnValidInput() throws URISyntaxException {
      File file = new File(getClass().getResource("/br/com/felipezorzo/sonar/plsql/code.sql").toURI());
      SourceCode source = new SourceCode(new SourceCode.FileCodeLoader(file, "key"));
      Tokens cpdTokens = new Tokens();
      PlSqlTokenizer tokenizer = new PlSqlTokenizer(Charset.forName("UTF-8"));
      tokenizer.tokenize(source, cpdTokens);
      List<TokenEntry> list = cpdTokens.getTokens();
      assertThat(list.size()).isEqualTo(39);
    }
    
}
