/**
 * The Subversion Authentication Parse Module (SAPM for short).
 *
 * Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2010, 2011 by Karl Heinz Marbaise
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 *
 * The License can viewed online under http://www.gnu.org/licenses/gpl.html
 * If you have any questions about the Software or about the license
 * just write an email to license@soebes.de
 */
package com.soebes.subversion.sapm;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.Group;
import com.soebes.subversion.sapm.User;

public class GroupTest extends TestBase {

    private Group developerGroup;
    private User userHarry;
    private User userBrian;

    @BeforeClass
    public void beforeClass() {
        userHarry = new User("harry");
        userBrian = new User("brian");
        developerGroup = new Group("developer");

        // @developer = harry, brian
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);
    }

    @Test
    public void groupAddTest() {
        Assert.assertEquals(2, developerGroup.getUserList().size());
    }

    @Test
    public void groupContainsTest() {
        Assert.assertTrue(developerGroup.contains(userHarry.getName()));
        Assert.assertTrue(developerGroup.contains(userHarry));
        Assert.assertTrue(developerGroup.contains(userBrian));

        Assert.assertFalse(developerGroup.contains("michael"));
    }
}
