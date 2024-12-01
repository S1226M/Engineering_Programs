------------------------------Part A----------------------------
--1. Retrieve a unique genre of songs.
Select Distinct Genre From Songs

--2. Find top 2 albums released before 2010. 
Select Top 2 Album_title from Albums Where Release_year < '2010'

--3. Insert Data into the Songs Table. (1245, ‘Zaroor’, 2.55, ‘Feel good’, 1005) 
Insert into Songs
values
(1245,'Zaroor',2.55,'Feel good', 1005)


--4. Change the Genre of the song ‘Zaroor’ to ‘Happy’
Update Songs Set Genre = 'Happy' where Genre = 'Zaroor'  

--5. Delete an Artist ‘Ed Sheeran’ 
Delete from Artists Where Artist_name = 'Ed Sheeran'

--6. Add a New Column for Rating in Songs Table. [Ratings decimal(3,2)] 
Alter table Songs Add Ratings Decimal(3,2)

--7. Retrieve songs whose title starts with 'S'. 
Select Song_title from Songs Where Song_title Like 'S%'

--8. Retrieve all songs whose title contains 'Everybody'. 
Select Song_title from Songs Where Song_title Like '%Everybody%'

--9. Display Artist Name in Uppercase. 
Select UPPER(Artist_name) from Artists

--10. Find the Square Root of the Duration of a Song ‘Good Luck’ 
Select SQRT(Duration) from Songs Where Song_title = 'Good Luck'

--11. Find Current Date. 
Select GETDATE()

--12. Find the number of albums for each artist. 
Select Count(Album_id)
from Albums join Artists
On Albums.Artist_id = Artists.Artist_id 
Group By Artists.Artist_name

--13. Retrieve the Album_id which has more than 5 songs in it. 
Select Albums.Album_id
From Albums Join Songs
On Albums.Album_id = Songs.Album_id
Group By Albums.Album_id
Having Count(Song_id) > 5

--14. Retrieve all songs from the album 'Album1'. (using Subquery) 
Select Songs.Song_title 
from Songs join Albums
on Songs.Album_id = Albums.Album_id
where Albums.Album_title = 'Album1'

--15. Retrieve all albums name from the artist ‘Aparshakti Khurana’ (using Subquery) 
Select Albums.Album_title 
from Albums join Artists
On Albums.Artist_id = Artists.Artist_id
Where Artists.Artist_name = 'Aparshakti Khurana'

--16. Retrieve all the song titles with its album title. 
Select Songs.Song_title,Albums.Album_title
from Songs join Albums
on Songs.Album_id = Albums.Album_id
 
--17. Find all the songs which are released in 2020. 
Select Song_title 
from Songs join Albums
on Songs.Album_id = Albums.Album_id
Where Release_year = 2020

--18. Create a view called ‘Fav_Songs’ from the songs table having songs with song_id 101-105.  
Create view Fav_Songs
As
Select * from Songs Where Song_id Between 101 And 105

--19. Update a song name to ‘Jannat’ of song having song_id 101 in Fav_Songs view. 


--20. Find all artists who have released an album in 2020.  
--21. Retrieve all songs by Shreya Ghoshal and order them by duration.