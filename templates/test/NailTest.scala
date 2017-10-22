${packagename}

/*
 * Copyright ${year} the original author ${author} or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import collection.mutable.Stack
import org.scalatest._

class ${classname}Spec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[String]()
    stack.push("abc")
    stack.push("xyz")
    stack.pop() should be ("xyz")
    stack.pop() should be ("abc")
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]()
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    } 
  }
}