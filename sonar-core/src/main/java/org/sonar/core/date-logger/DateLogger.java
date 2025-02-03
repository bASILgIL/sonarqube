/*
 * SonarQube
 * Copyright (C) 2009-2025 SonarSource SA
 * mailto:info AT sonarsource DOT com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.core.datelogger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class DateLogger {

    public static boolean createDateLog()
    {
      String currentDir = Paths.get("").toAbsolutePath().toString();
      String filePath = Paths.get(currentDir, "last_startup.txt").toString();

      try (FileWriter writer = new FileWriter(filePath)) {
        writer.write(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        return true;
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }
}