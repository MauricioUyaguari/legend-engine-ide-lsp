// Copyright 2023 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.ide.lsp.extension;

import org.finos.legend.engine.language.pure.grammar.from.extension.PureGrammarParserExtensions;
import org.finos.legend.engine.language.pure.grammar.from.runtime.RuntimeParser;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.PackageableElement;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.runtime.PackageableRuntime;

import java.util.List;

/**
 * Extension for the Runtime grammar.
 */
public class RuntimeLSPGrammarExtension extends AbstractLegacyParserLSPGrammarExtension
{
    private static final List<String> KEYWORDS = List.of("Runtime", "import");

    public RuntimeLSPGrammarExtension()
    {
        super(RuntimeParser.newInstance(PureGrammarParserExtensions.fromAvailableExtensions()));
    }

    @Override
    public Iterable<? extends String> getKeywords()
    {
        return KEYWORDS;
    }

    @Override
    protected String getClassifier(PackageableElement element)
    {
        return (element instanceof PackageableRuntime) ? "meta::pure::runtime::PackageableRuntime" : null;
    }
}