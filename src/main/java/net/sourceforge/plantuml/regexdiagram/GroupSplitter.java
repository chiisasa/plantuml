/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2024, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * https://plantuml.com/patreon (only 1$ per month!)
 * https://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.regexdiagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.plantuml.jaws.JawsStrange;

public class GroupSplitter {

	@JawsStrange
	public List<String> split(String group) {
		final List<String> result = new ArrayList<>();
		for (int i = 0; i < group.length(); i++) {
			if (i + 2 < group.length() && group.charAt(i + 1) == '-') {
				result.add("" + group.substring(i, i + 3));
				i += 2;
			} else if (i + 1 < group.length() && group.charAt(i) == '\\') {
				result.add("" + group.substring(i, i + 2));
				i++;
			} else
				result.add("" + group.charAt(i));
		}
		return Collections.unmodifiableList(result);
	}

}
