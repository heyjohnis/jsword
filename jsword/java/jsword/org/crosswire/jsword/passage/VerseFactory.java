package org.crosswire.jsword.passage;


/**
 * A factory to create a Verse from user input.
 * 
 * <p><table border='1' cellPadding='3' cellSpacing='0'>
 * <tr><td bgColor='white' class='TableRowColor'><font size='-7'>
 *
 * Distribution Licence:<br />
 * JSword is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License,
 * version 2 as published by the Free Software Foundation.<br />
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br />
 * The License is available on the internet
 * <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, or by writing to:
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
 * MA 02111-1307, USA<br />
 * The copyright to this program is held by it's authors.
 * </font></td></tr></table>
 * @see gnu.gpl.Licence
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public final class VerseFactory
{
    /**
     * Prevent a VerseFactory from being created.
     */
    private VerseFactory()
    {
    }

    /**
     * Construct a Verse from a String - something like "Gen 1:1".
     * in case the user does not want to have their typing 'fixed' by a
     * meddling patronizing computer. The following initial letters can
     * not be matched at all - 'bfquvwx'.
     * @param original The text string to be converteds
     * @return the Verse representation of the string
     * @exception NoSuchVerseException If the text can not be understood
     */
    public static Verse fromString(String original) throws NoSuchVerseException
    {
        if ("".equals(original)) //$NON-NLS-1$
        {
            return null;
        }
        String[] parts = AccuracyType.tokenize(original);
        AccuracyType accuracy = AccuracyType.fromText(parts);
        assert accuracy != null;
        return accuracy.createStartVerse(original, null, parts);
    }

    /**
     * Construct a Verse from a String and a VerseRange. For example given "2:2"
     * and a basis of Gen 1:1 - 12 the result would be Gen 2:2
     * @param original The string describing the verse e.g "2:2"
     * @param verseRangeBasis The basis by which to understand the desc.
     * @return the verse representation of the string
     * @exception NoSuchVerseException If the reference is illegal
     */
    public static Verse fromString(String original, VerseRange verseRangeBasis) throws NoSuchVerseException
    {
        if ("".equals(original)) //$NON-NLS-1$
        {
            return null;
        }
        String[] parts = AccuracyType.tokenize(original);
        AccuracyType accuracy = AccuracyType.fromText(parts, null, verseRangeBasis);
        assert accuracy != null;
        return accuracy.createStartVerse(original, verseRangeBasis, parts);
    }

}