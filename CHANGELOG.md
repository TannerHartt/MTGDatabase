```
Monday, March 7:
```
- First commit setting up basic Tomcat Server.
- Divided program into separate classes.
- Set up H2 database tables and populated with a few elements.

```
Wednesday, March 9:
```
- Began database switch to Postgres from H2.
- Added some images for testing.

```
Sunday, March 13:
```
- Set up default servlet to redirect to landing page.
- Improvements to js and html file.

```
Monday, March 14:
```
- Set up basic landing page to begin adding functionality.
- Fixed connection to H2 sql database.
- Updated dependencies to newer versions.

```
Tuesday, March 15:
```
- Fixed bug with sql database url.
- Added basic insert into database functionality.
- Began to dockerize my project, adding dockerfiles.
- Created executable jar.
- Added event listener to insert button to change when hovered.
- Added magic the gathering logo at the top of each page.

```
Wednesday, March 16:
```
- Began reformatting the insert into database functionality with a table.
- Created glass gradient in css for table and buttons.
- Properly seperated code into separate classes.
- Added some javadocs documentation.
- Made text in database print to page in bold.
- Changed welcome message to magic theme.

```
Thursday, March 17:
```
- Improvements to Javadocs.
- Created a new landing page and added buttons to other servlets.
- Added search bar without functionality.
- Added an extra servlet mapping and linked it to a button on the landing page.
- Created several css classes and ids to use on all pages with formatting.
- Minor improvements to scripts.

```
Friday, March 18:
```
- Added more servlet mappings and linked them to buttons on landing page for future implementation.
- Reworked landing page with icons.
- Added search icon within search bar.
- Added glass gradient to all buttons and search bar.
- Added transparent png icons for future use.
- Created custom checkbox slider, meant to change background gradient (not functional).

```
Saturday, March 19:
```
- Added settings icon to landing page with logging and raw data buttons behind animation.
- Began populating database with entries.
- Began setting up addCard page with background and buttons.
- Added anim.js file to handle the animation.
- Disabled insert into database functionality temporarily to rebuild it.
- Set up random card page with functionality and unique background gradient.
- Refactored code to add more fields for each card entry.
- Improvements to random card page with button to re-roll the random card.
- Improved the math function used to determine the random card output.
- Added more sql tables to represent values in the main table.
- Began complete overhaul of the card creation page.
- Added more css styles to use with buttons.
- Added href to the magic logo on each page to lead back to landing page.
- Further population of the database.


```
Sunday, March 20:
```
- Added 50+ more entries into the database.
- Added one more field to entries for each card's unique Scryfall id.
- Added a href to each card image in the all cards list that maps to an animated, focused view.
- Set up proper search functionality.
- Made search non-case sensitive and dynamic to incorrect inputs.
- Attempt at implementing a logging system.
- Minor improvements to html and js files.
- Created glassy buttons below the page to the creators GitHub accounts.
- Further addition of card fields to hold more values.
- Changed background image in the card creation page.
- Began to transition add card page to view card functionality.
- Fixed unique case where all cards list would extend beyond the page bottom.
- Several minor quality improvements.
- Added base image for card creation.
- Code cleanup in all files.