package org.crosswire.jsword.book.stub;

import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.BookMetaData;
import org.crosswire.jsword.book.BookType;
import org.crosswire.jsword.book.basic.DefaultBookMetaData;
import org.crosswire.jsword.book.basic.PassageAbstractBook;
import org.crosswire.jsword.book.filter.Filter;
import org.crosswire.jsword.book.filter.FilterFactory;
import org.crosswire.jsword.passage.Verse;

/**
 * StubBook is a simple stub implementation of Book that is pretty much
 * always going to work because it has no dependancies on external files.
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
public class StubBook extends PassageAbstractBook
{
    /**
     * Basic constructor for a StubBook
     */
    public StubBook(StubBookDriver driver, String name, BookType type, int speed)
    {
        BookMetaData bmd = new DefaultBookMetaData(driver, this, name, type, speed);
        setBookMetaData(bmd);

        initSearchEngine();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.basic.PassageAbstractBook#getFilter()
     */
    protected Filter getFilter()
    {
        return FilterFactory.getDefaultFilter();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.basic.PassageAbstractBook#getText(org.crosswire.jsword.passage.Verse)
     */
    protected String getText(Verse verse)
    {
        return "stub implementation"; //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.basic.PassageAbstractBook#setText(org.crosswire.jsword.passage.Verse, java.lang.String)
     */
    protected void setText(Verse verse, String text) throws BookException
    {
        throw new BookException(Msg.DRIVER_READONLY);
    }
}
