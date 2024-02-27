# Project : WeightLess Fitness App
The "fitappfinalV2" file contains all the files and source code for the WeightLess app. To run the app just download the "fitappfinalV2" file and open it in android studios.


##### Problem Area: 

This project aims to tackle the global obesity crisis as it been reported by EASO that obesity and being overweight is the 5th global cause of death (EASO, 2020). Despite abundant online information, misinformation and lack of motivation and engaging solutions hinder effective weight loss (Nakul, 2022). To combat this issue I created a Fitness app called "WeightLess". The Fitness app had a Calorie and Workout Tracker which required the need for a SQLite database and SQL queries to manipulate data within the SQLite database.

##### Methodology: 

The project introduces a mobile fitness app with educational features, goal setting, and tracking, as upon research they had shown promising user engagement results (Consagoustech, 2023). I implemented the app using Android Studios where XML was used for the Front End and for the Backend I mainly used java for the functionality of the app and SQL for the database.

Weight Less included many features: 

• Calorie Tracker – A feature used to track the daily calorie intake of the user, the details of which the user enters manually. The entry is stored in a separate SQLite database and displayed back to the user to see their progress.  

• Workout Tracker - A feature used to track the Workout the user has done, the details of which the user enters manually. The entry is stored in a separate SQLite database and displayed back to the user to see their progress.  

• Information Station – A feature aimed to educate the user on sustainable WeightLoss, Workout Routines and Meal plans.
  
• Calorie Goal Calculator – A feature that calculates a user’s caloric goal based on their biometric data.

##### Results:
![Slide4](https://github.com/GK2103/GK2103.github.io/assets/99646891/cb9d36e0-77a7-43bb-ab30-bc2134e71910)
![Slide5](https://github.com/GK2103/GK2103.github.io/assets/99646891/69227769-8518-4d7b-8338-56d0c0825f50)
![Slide6](https://github.com/GK2103/GK2103.github.io/assets/99646891/abd103a3-6385-4f97-ac16-8fe03340426b)
![Slide7](https://github.com/GK2103/GK2103.github.io/assets/99646891/890fde5a-7306-412b-896b-3d4b0829f8b3)

##### Implementation: 
 
Both tracking features were implemented by using an SQLite Database, and I wrote SQL queries using both Java and SQL to insert, edit and delete values in the database. Subsequently, I displayed this information to the user in an appealing format and provided functionality to modify or delete existing entries.

I created the "workoutdata" SQLite database within the DBHelper Java class, as can be observed in the Results section below, specifically on lines 9 and 10 of Figure 5. Next, I proceeded to create a table named "Workoutdata" using the .execSQL Java function, as demonstrated on line 16. This SQL query defined a table with columns for exercise, sets, reps, and weight, with the exercise column serving as the primary key.
 

1.	View Entries: Users click "Workout Tracker" on the home page and are taken to the “Workout Tracker” Page (seen in Figure 2) and can see their stored exercise entries.
   
2.	Add Exercise: They can add new exercises by clicking a green button, which takes them to an “Add Exercise” page (seen in Figure 3), When they submit this data, the "add_exercise" Java class captures the information and saves it using the "saveuserdata" method from the "DBhelper" class. This data is stored in the "workoutdata" database.
   
3.	Display Data: The "Workout_Diary" class retrieves data from the database via the "displaydata" and "getdata" methods found in the, storing it in ArrayLists.
   
4.	UI Population: An instance of "MyAdapter" formats the data for display in a RecyclerView, showing both new and previous entries.
   
5.	Edit/Delete Entries: Users can edit or delete entries by clicking them. In doing do they would be taken to the “Edit Exercise Log”. Editing updates data in the database using "updateuserdata," and deletion uses "deleteuserdata." Both these methods use a combination of both Java and SQL to manipulate the “Workoutdata” Table and change the entries that are saved in the table. 

Further details on the implementation and the code for the app can be found in the code file and the research paper written about the implementation effectiveness of the app

###### References:

Halford, J. (2020) Statistics, EASO. Available at: 	https://easo.org/media-portal/statistics/ (Accessed: January 17, 2023). 

Nakul (2022) Rise of misinformation in the fitness industry, TheSocialTalks. Available at: https://thesocialtalks.com/health/rise-of-misinformation-in-the-fitness-industry/?utm_content=cmp-true (Accessed: 24 May 2023). 

Consagoustech (2023) From download to delete: The real reasons fitness apps fail users, Medium. Available at: https://medium.com/@itsconsagous/from-download-to-delete-the-real-reasons-fitness-apps-fail-users-b2e86424163d (Accessed: 15 August 2023).
