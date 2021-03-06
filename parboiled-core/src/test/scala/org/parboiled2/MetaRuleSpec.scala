/*
 * Copyright (C) 2009-2013 Mathias Doenitz, Alexander Myltsev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled2

class MetaRuleSpec extends TestParserSpec {

  "Meta rules" should {

    "work as expected" in new TestParser0 {
      val targetRule = rule { bracketed1(ab) ~ bracketed2(cd) }
      val ab = rule { "ab" }
      val cd = rule { "cd" }
      val bracketed1 = rule[Rule0]() { inner ⇒ '[' ~ inner ~ ']' }
      def bracketed2(inner: Rule0) = rule { '[' ~ inner ~ ']' }

      "[ab][cd]" must beMatched
      "abcd" must beMismatched
    }
  }
}