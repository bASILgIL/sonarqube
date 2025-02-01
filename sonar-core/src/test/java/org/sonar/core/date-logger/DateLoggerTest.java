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

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class DateLoggerTest {

  @Test
  public void testCreateDateLogSuccess() throws IOException {
    // Ensure the file does not exist before the test
    String filePath = Paths.get("", "last_startup.txt").toAbsolutePath().toString();
    Files.deleteIfExists(Paths.get(filePath));

    // Test the createDateLog method
    boolean result = DateLogger.createDateLog();
    assertTrue(result, "The log file should be created successfully");

    // Verify the file was created
    assertTrue(Files.exists(Paths.get(filePath)), "The log file should exist");
  }

  @Test
  public void testCreateDateLogDate()
  {
    // Make sure the content of the file starts with 2025
    DateLogger.createDateLog();
    String filePath = Paths.get("", "last_startup.txt").toAbsolutePath().toString();
    try{
      String content = Files.readString(Paths.get(filePath));
      assertTrue(content.startsWith("2025"), "The log file should start with 2025");
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}