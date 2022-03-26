This project was created as a part of our submission to Alegria hackathon 2022.

# Angel
<img src="https://cdn.discordapp.com/attachments/955875342910902282/955875353480548382/unknown.png"/>

In 2022, everything is rapidly digitizing. Technology plays a crucial role in every part of our lives. Every day, new types of systems get born to simplify some part of our lives. However, niche problems such as managment systems for organizations don't seem to be technologically very successful. According to our survey for the case in point, there is no portable and user-friendly mobile application which exists for old age home management.

To solve this problem, we are introducing *Angel* ❤️

Angel is a portable, user-friendly and administrative application which allows old age homes to break from traditional routines of keeping a logbook and doing everything manually. This application automates most of the manual work and allows for efficient searching through data.  


## Features
Keeping some use cases of a typical old age home in mind, we have implemented the following features. All of them are accessible through the admin user's dashboard.


<img src="https://cdn.discordapp.com/attachments/742639290416234543/957171727736119337/unknown.png"/>

### Records
This module offers a read-and-delete-only profile based view of 
each inhabitant in the old age home. The entries are directly fetched from the 
central database. Here, the management staff can directly view all the 
inhabitants, view the profile of individuals, or delete an inhabitant's profile.


### Manage Data
This is a write-only method in which the management staff can add the users. 
It is based on parameters of an inhabitant such as phone number, name etc. This
populates the database and further, the Records section.

### Food
Old age homes often have a weekly schedule which they follow for breakfast/lunch/dinner. For preparing recipes, they have a stockpile of ingredients as well. 

To manage both of these, our application has a section allocated to Food, which
has two subsections. 

- The first is for meals, where managers and other staff can view or change the 
current meal schedule.

- The second is for raw ingredients. Here, the staff can view or change the 
amount of raw ingredients that are currently available.


### Medicines

Old age homes keep a good amount of stockpile of medicines for the inhabitants.
They also follow a schedule for dosages. E.g. An inhabitant suffering from a 
long term diabetes might take regular injections.
For this, the project has a section dedicated to medicines, which is further
divided into two subsections. 
The first one is for keeping a watch over the upcoming timings of dosages. The
dosage entries are sorted according to the time. e.g. If the current time is
6:45PM and an inhabitant needs the medicine at 7:00PM, then that reminder will
be displayed at the top and it'll be color coded.

The second one keeps track of the medicine stockpile. Similar to food, the staff
can view or change the current amount of medicine that's available.

### Emergency
Old age homes often face panic situations. These can be of various forms, 
maybe a fire hazard, maybe a robbery or maybe an emergency medical incident.

For covering these cases, Angel provides an Emergency section which can be 
used in panic situations. To improve the UX, all buttons in this section are
kept as large and distinct as possible, so that they can be pressed in a panic.

There are 3 main buttons, for Police, Ambulance and Fire station. This section
also offers a directory-like view, which offers extra callable contacts who
can be dialed to in the times of great need.


### FAQ
This section offers help for our application in the form of QnA. It is mainly
aimed towards new staff for helping them to get familiarized with the application.
