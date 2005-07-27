/**
 * Distribution License:
 * JSword is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License, version 2.1 as published by
 * the Free Software Foundation. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The License is available on the internet at:
 *       http://www.gnu.org/copyleft/lgpl.html
 * or by writing to:
 *      Free Software Foundation, Inc.
 *      59 Temple Place - Suite 330
 *      Boston, MA 02111-1307, USA
 *
 * Copyright: 2005
 *     The copyright to this program is held by it's authors.
 *
 * ID: $Id$
 */
package org.crosswire.jsword.passage;

import junit.framework.TestCase;

import org.crosswire.jsword.book.CaseType;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public class BibleInfoTest extends TestCase
{
    public BibleInfoTest(String s)
    {
        super(s);
    }

    private CaseType storedCase;

    protected void setUp()
    {
        storedCase = BibleInfo.getDefaultCase();
    }

    protected void tearDown()
    {
        BibleInfo.setCase(storedCase);
    }

    public void testCase() throws Exception
    {
        BibleInfo.setCase(CaseType.LOWER);
        assertEquals(BibleInfo.getDefaultCase(), CaseType.LOWER);

        BibleInfo.setCase(CaseType.UPPER);
        assertEquals(BibleInfo.getDefaultCase(), CaseType.UPPER);

        BibleInfo.setCase(CaseType.SENTENCE);
        assertEquals(BibleInfo.getDefaultCase(), CaseType.SENTENCE);
    }

    public void testGetLongBookName() throws Exception
    {
        BibleInfo.setCase(CaseType.SENTENCE);
        assertEquals(BibleInfo.getLongBookName(1), "Genesis"); //$NON-NLS-1$
        assertEquals(BibleInfo.getLongBookName(66), "Revelation"); //$NON-NLS-1$

        BibleInfo.setCase(CaseType.LOWER);
        assertEquals(BibleInfo.getLongBookName(1), "genesis"); //$NON-NLS-1$
        assertEquals(BibleInfo.getLongBookName(66), "revelation"); //$NON-NLS-1$

        BibleInfo.setCase(CaseType.UPPER);
        assertEquals(BibleInfo.getLongBookName(1), "GENESIS"); //$NON-NLS-1$
        assertEquals(BibleInfo.getLongBookName(66), "REVELATION"); //$NON-NLS-1$

        try
        {
            BibleInfo.getLongBookName(0);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        try
        {
            BibleInfo.getLongBookName(67);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }
    }

    public void testGetShortBookName() throws Exception
    {
        BibleInfo.setCase(CaseType.SENTENCE);
        try
        {
            BibleInfo.getShortBookName(0);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        assertEquals(BibleInfo.getShortBookName(1), "Gen"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(2), "Exo"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(7), "Judg"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(39), "Mal"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(40), "Mat"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(50), "Phili"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(57), "Phile"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(65), "Jude"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(66), "Rev"); //$NON-NLS-1$

        try
        {
            BibleInfo.getShortBookName(67);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        BibleInfo.setCase(CaseType.LOWER);
        try
        {
            BibleInfo.getShortBookName(0);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        assertEquals(BibleInfo.getShortBookName(1), "gen"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(2), "exo"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(7), "judg"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(39), "mal"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(40), "mat"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(50), "phili"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(57), "phile"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(65), "jude"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(66), "rev"); //$NON-NLS-1$

        try
        {
            BibleInfo.getShortBookName(67);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        BibleInfo.setCase(CaseType.UPPER);
        try
        {
            BibleInfo.getShortBookName(0);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        assertEquals(BibleInfo.getShortBookName(1), "GEN"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(2), "EXO"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(7), "JUDG"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(39), "MAL"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(40), "MAT"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(50), "PHILI"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(57), "PHILE"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(65), "JUDE"); //$NON-NLS-1$
        assertEquals(BibleInfo.getShortBookName(66), "REV"); //$NON-NLS-1$

        try
        {
            BibleInfo.getShortBookName(67);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }
    }

    public void testGetBookJogger() throws Exception
    {
        assertEquals(BibleInfo.getOSISName(1), "Gen"); //$NON-NLS-1$
        assertEquals(BibleInfo.getOSISName(2), "Exod"); //$NON-NLS-1$
        assertEquals(BibleInfo.getOSISName(66), "Rev"); //$NON-NLS-1$

        try
        {
            BibleInfo.getOSISName(0);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }

        try
        {
            BibleInfo.getOSISName(67);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }
    }

    public void testGetBookNumber() throws Exception
    {
        assertEquals(BibleInfo.getBookNumber("Genesis"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("Gene"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("Gen"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("G"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("g"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("GEN"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("genesis"), 1); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("psa"), 19); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("ps"), 19); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("pss"), 19); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("psalter"), 19); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("ecc"), 21); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("Qohelot"), 21); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("son"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("song"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("song of solomon"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("songofsolomon"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("ss"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("canticle"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("can"), 22); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("phi"), 50); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("phil"), 50); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("phili"), 50); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("phile"), 57); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("revelations"), 66); //$NON-NLS-1$
        assertEquals(BibleInfo.getBookNumber("rev"), 66); //$NON-NLS-1$

        if (BibleInfo.getBookNumber("b") != -1) //$NON-NLS-1$
        {
            fail();
        }

        assertEquals(BibleInfo.getBookNumber("1"), -1); //$NON-NLS-1$
    }

    public void testIn() throws Exception
    {
        assertEquals(BibleInfo.versesInBook(1), 1533);
        assertEquals(BibleInfo.versesInBook(66), 404);

        // Counts using loops
        int viw_b = 0;
        int viw_c = 0;
        int ciw = 0;

        // For all the books
        for (int b = 1; b <= BibleInfo.booksInBible(); b++)
        {
            // Count and check the verses in this book
            int vib = 0;
            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                vib += BibleInfo.versesInChapter(b, c);
            }
            assertEquals(vib, BibleInfo.versesInBook(b));

            // Continue the verse counts for the whole Bible
            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                viw_c += BibleInfo.versesInChapter(b, c);
            }

            viw_b += BibleInfo.versesInBook(b);

            // Continue the chapter count for the whole Bible
            ciw += BibleInfo.chaptersInBook(b);
        }
        assertEquals(BibleInfo.versesInBible(), viw_b);
        assertEquals(BibleInfo.versesInBible(), viw_c);
        assertEquals(BibleInfo.chaptersInBible(), ciw);
        assertEquals(BibleInfo.booksInBible(), 66);
    }

    public void testOrdinal() throws Exception
    {
        int first_verse_ord = 1;
        int last_verse_ord = 1;
        for (int b = 1; b <= BibleInfo.booksInBible(); b++)
        {
            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                last_verse_ord = first_verse_ord + BibleInfo.versesInChapter(b, c) - 1;

                assertEquals(first_verse_ord, BibleInfo.verseOrdinal(b, c, 1));
                assertEquals(first_verse_ord, BibleInfo.verseOrdinal(new int[] { b, c, 1 }));
                assertEquals(first_verse_ord + 1, BibleInfo.verseOrdinal(b, c, 2));
                assertEquals(first_verse_ord + 1, BibleInfo.verseOrdinal(new int[] { b, c, 2 }));
                assertEquals(last_verse_ord, BibleInfo.verseOrdinal(b, c, BibleInfo.versesInChapter(b, c)));
                assertEquals(last_verse_ord, BibleInfo.verseOrdinal(new int[] { b, c, BibleInfo.versesInChapter(b, c)}));

                assertEquals(BibleInfo.verseCount(new int[] { b, c, 1 }, BibleInfo.decodeOrdinal(first_verse_ord)), 1);
                assertEquals(BibleInfo.verseCount(new int[] { b, c, 2 }, BibleInfo.decodeOrdinal(first_verse_ord + 1)), 1);
                assertEquals(BibleInfo.verseCount(new int[] { b, c, BibleInfo.versesInChapter(b, c)}, BibleInfo.decodeOrdinal(last_verse_ord)), 1);

                first_verse_ord += BibleInfo.versesInChapter(b, c);
            }
        }
    }

    public void testValidate() throws Exception
    {
        try
        {
            BibleInfo.validate(0, 1, 1);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }
        for (int b = 1; b < BibleInfo.booksInBible(); b++)
        {
            try
            {
                BibleInfo.validate(b, 0, 1);
                fail();
            }
            catch (NoSuchVerseException ex)
            {
            }
            try
            {
                BibleInfo.validate(b, 1, 0);
                fail();
            }
            catch (NoSuchVerseException ex)
            {
            }

            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                try
                {
                    BibleInfo.validate(b, c, 0);
                    fail();
                }
                catch (NoSuchVerseException ex)
                {
                }

                for (int v = 1; v <= BibleInfo.versesInChapter(b, c); v++)
                {
                    BibleInfo.validate(b, c, v);
                    // This fn is tested as exhaustivly as the validate(int, int, int)
                    // version however since is is only a bit of sugar this is OK
                    BibleInfo.validate(new int[] { b, c, v });
                }
                try
                {
                    BibleInfo.validate(b, c, BibleInfo.versesInChapter(b, c) + 1);
                    fail();
                }
                catch (NoSuchVerseException ex)
                {
                }
            }

            try
            {
                BibleInfo.validate(67, BibleInfo.chaptersInBook(b) + 1, 1);
                fail();
            }
            catch (NoSuchVerseException ex)
            {
            }
            try
            {
                BibleInfo.validate(67, 1, BibleInfo.versesInBook(b) + 1);
                fail();
            }
            catch (NoSuchVerseException ex)
            {
            }
        }
        try
        {
            BibleInfo.validate(67, 1, 1);
            fail();
        }
        catch (NoSuchVerseException ex)
        {
        }
    }

    public void testPatch() throws Exception
    {
        int all = 1;
        for (int b = 1; b < BibleInfo.booksInBible(); b++)
        {
            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                for (int v = 1; v <= BibleInfo.versesInChapter(b, c); v++)
                {
                    int[] simple = { 1, 1, all++ };
                    int[] complex = { b, c, v };
                    BibleInfo.patch(simple);

                    assertEquals(simple[BibleInfo.BOOK], complex[BibleInfo.BOOK]);
                    assertEquals(simple[BibleInfo.CHAPTER], complex[BibleInfo.CHAPTER]);
                    assertEquals(simple[BibleInfo.VERSE], complex[BibleInfo.VERSE]);
                }
            }
        }
        int[] v111 = { 1, 1, 1 };
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 1, 1, 1 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 1, 1, 0 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 1, 0, 1 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 1, 0, 0 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 0, 1, 1 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 0, 1, 0 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 0, 0, 1 })), 1);
        assertEquals(BibleInfo.verseCount(v111, BibleInfo.patch(new int[] { 0, 0, 0 })), 1);
    }

    public void testVerseCount() throws Exception
    {
        int count_up = 0;
        int count_down = 31102;
        for (int b = 1; b < BibleInfo.booksInBible(); b++)
        {
            for (int c = 1; c <= BibleInfo.chaptersInBook(b); c++)
            {
                for (int v = 1; v <= BibleInfo.versesInChapter(b, c); v++)
                {
                    int up = BibleInfo.verseCount(1, 1, 1, b, c, v);
                    int down = BibleInfo.verseCount(b, c, v, 66, 22, 21);

                    assertEquals(up, ++count_up);
                    assertEquals(down, count_down--);

                    assertEquals(BibleInfo.verseCount(new int[] { 1, 1, 1 }, new int[] { b, c, v }), verseCountSlow(1, 1, 1, b, c, v));
                }
            }

            assertEquals(BibleInfo.verseCount(b, 1, 1, b, BibleInfo.chaptersInBook(b), BibleInfo.versesInChapter(b, BibleInfo.chaptersInBook(b))), BibleInfo.versesInBook(b));
        }
        assertEquals(BibleInfo.verseCount(1, 1, 1, 2, 1, 1), BibleInfo.versesInBook(1) + 1);
        assertEquals(BibleInfo.verseCount(1, 1, 1, 1, 1, 10), 10);
    }

    public void testNames() throws Exception
    {
        assertEquals(BibleInfo.Names.GENESIS, 1);
        assertEquals(BibleInfo.Names.REVELATION, 66);
    }

    /**
     * This is code from BibleInfo that was needed only as part of testing, so I
     * Moved it here. How many verses between ref1 and ref2 (inclusive).
     * @param book1 The book part of the first reference.
     * @param chapter1 The chapter part of the first reference.
     * @param verse1 The verse part of the first reference.
     * @param book2 The book part of the second reference.
     * @param chapter2 The chapter part of the second reference.
     * @param verse2 The verse part of the second reference.
     * @exception NoSuchVerseException If either reference is illegal
     */
    protected int verseCountSlow(int book1, int chapter1, int verse1, int book2, int chapter2, int verse2) throws NoSuchVerseException
    {
        BibleInfo.validate(book1, chapter1, verse1);
        BibleInfo.validate(book2, chapter2, verse2);

        int count = 0;

        // If we are in different books, count the verses until the books are the same
        if (book1 != book2)
        {
            // 1st count to the end of the chapter
            count += BibleInfo.versesInChapter(book1, chapter1) - verse1 + 1;

            // Then count from the end of the chapter to the end of the book
            for (int c = chapter1 + 1; c <= BibleInfo.chaptersInBook(book1); c++)
                count += BibleInfo.versesInChapter(book1, c);

            // Then count until the books are the same
            for (int b = book1 + 1; b < book2; b++)
                count += BibleInfo.versesInBook(b);

            // The new position
            book1 = book2;
            chapter1 = 1;
            verse1 = 1;
        }

        // Count the verses in the chapters so that we are in the same chapter
        for (int c = chapter1; c < chapter2; c++)
            count += BibleInfo.versesInChapter(book2, c);

        // And finally the verses in the final chapter
        count += verse2 - verse1 + 1;

        return count;
    }
}
