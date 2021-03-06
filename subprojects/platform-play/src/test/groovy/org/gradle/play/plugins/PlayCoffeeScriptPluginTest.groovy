/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.play.plugins

import org.gradle.language.coffeescript.CoffeeScriptSourceSet
import org.gradle.platform.base.PlatformBaseSpecification

class PlayCoffeeScriptPluginTest extends PlatformBaseSpecification {
    def "adds coffeescript source sets to play components" () {
        when:
        dsl {
            apply plugin: PlayCoffeeScriptPlugin
            apply plugin: PlayApplicationPlugin
        }

        then:
        def component = realizeComponents().play
        component.sources.coffeeScript instanceof CoffeeScriptSourceSet
        component.sources.coffeeScript.source.srcDirs == [project.file('app/assets')] as Set
        component.sources.coffeeScript.source.includes == ["**/*.coffee"] as Set
    }
}
