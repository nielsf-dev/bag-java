/*
 * Copyright 2009 the original author or authors.
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


import org.bag.controllers.UpdaterProjectController
import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProjectListItem
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.data.domain.Sort
import spock.lang.Specification

// om te runnen zonder warnings dit toevoegen bij run configuration -> VM Options:
// --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.annotation=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED --add-opens=java.base/java.lang.module=ALL-UNNAMED --add-opens=java.base/java.lang.ref=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.math=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/java.net.spi=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/java.nio.channels=ALL-UNNAMED --add-opens=java.base/java.nio.channels.spi=ALL-UNNAMED --add-opens=java.base/java.nio.charset=ALL-UNNAMED --add-opens=java.base/java.nio.charset.spi=ALL-UNNAMED --add-opens=java.base/java.nio.file=ALL-UNNAMED --add-opens=java.base/java.nio.file.attribute=ALL-UNNAMED --add-opens=java.base/java.nio.file.spi=ALL-UNNAMED --add-opens=java.base/java.security=ALL-UNNAMED --add-opens=java.base/java.security.acl=ALL-UNNAMED --add-opens=java.base/java.security.cert=ALL-UNNAMED --add-opens=java.base/java.security.interfaces=ALL-UNNAMED --add-opens=java.base/java.security.spec=ALL-UNNAMED --add-opens=java.base/java.text=ALL-UNNAMED --add-opens=java.base/java.text.spi=ALL-UNNAMED --add-opens=java.base/java.time=ALL-UNNAMED --add-opens=java.base/java.time.chrono=ALL-UNNAMED --add-opens=java.base/java.time.format=ALL-UNNAMED --add-opens=java.base/java.time.temporal=ALL-UNNAMED --add-opens=java.base/java.time.zone=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.util.concurrent=ALL-UNNAMED --add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED --add-opens=java.base/java.util.concurrent.locks=ALL-UNNAMED --add-opens=java.base/java.util.function=ALL-UNNAMED --add-opens=java.base/java.util.jar=ALL-UNNAMED --add-opens=java.base/java.util.regex=ALL-UNNAMED --add-opens=java.base/java.util.spi=ALL-UNNAMED --add-opens=java.base/java.util.stream=ALL-UNNAMED --add-opens=java.base/java.util.zip=ALL-UNNAMED --add-opens=java.datatransfer/java.awt.datatransfer=ALL-UNNAMED --add-opens=java.desktop/java.applet=ALL-UNNAMED --add-opens=java.desktop/java.awt=ALL-UNNAMED --add-opens=java.desktop/java.awt.color=ALL-UNNAMED --add-opens=java.desktop/java.awt.desktop=ALL-UNNAMED --add-opens=java.desktop/java.awt.dnd=ALL-UNNAMED --add-opens=java.desktop/java.awt.dnd.peer=ALL-UNNAMED --add-opens=java.desktop/java.awt.event=ALL-UNNAMED --add-opens=java.desktop/java.awt.font=ALL-UNNAMED --add-opens=java.desktop/java.awt.geom=ALL-UNNAMED --add-opens=java.desktop/java.awt.im=ALL-UNNAMED --add-opens=java.desktop/java.awt.im.spi=ALL-UNNAMED --add-opens=java.desktop/java.awt.image=ALL-UNNAMED --add-opens=java.desktop/java.awt.image.renderable=ALL-UNNAMED --add-opens=java.desktop/java.awt.peer=ALL-UNNAMED --add-opens=java.desktop/java.awt.print=ALL-UNNAMED --add-opens=java.desktop/java.beans=ALL-UNNAMED --add-opens=java.desktop/java.beans.beancontext=ALL-UNNAMED --add-opens=java.instrument/java.lang.instrument=ALL-UNNAMED --add-opens=java.logging/java.util.logging=ALL-UNNAMED --add-opens=java.management/java.lang.management=ALL-UNNAMED --add-opens=java.prefs/java.util.prefs=ALL-UNNAMED --add-opens=java.rmi/java.rmi=ALL-UNNAMED --add-opens=java.rmi/java.rmi.activation=ALL-UNNAMED --add-opens=java.rmi/java.rmi.dgc=ALL-UNNAMED --add-opens=java.rmi/java.rmi.registry=ALL-UNNAMED --add-opens=java.rmi/java.rmi.server=ALL-UNNAMED --add-opens=java.sql/java.sql=ALL-UNNAMED
class HelloSpockSpec extends Specification {
  def "length of Spock's and his friends' names"() {
    expect:
    name.size() == length

    where:
    name     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }

//  def "je moeder ruikt naar rotjes"(){
//    given:
//    def projectRepository = Stub(ProjectRepository.class)
//    projectRepository.findAll(Sort.by("order")) >>
//            [new Project(0,"first","loc","text",[new Image("test")]),
//             new Project(1,"second","loc","text",[new Image("test")])]
//
//    def updaterProjectController = new UpdaterProjectController(projectRepository,Mock(ImageRepository))
//
//    when:
//    def projects = updaterProjectController.listProjects()
//
//    then:
//    projects.size() == 2
//    projects.first().title == "first"
//  }

  def "de simpele when(stimulus)->then(response) variant"(){
    def lijstje = new ArrayList()
    when:
    lijstje.add(new Image("www.niels.nl"))

    then:
    lijstje.size() == 1
    lijstje.find() != null
  }
}  