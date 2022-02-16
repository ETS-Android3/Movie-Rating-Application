Movie Rating Application

Written in java using Android Studio

The functionality of the application relys on three main activities:
	
	-The MainActivity
	-The MovieAdapter activity
	-The Movie activity
	-And the ListItem activity
	
First is the MainActivity where:
	
	First the view elements are declared.
	
	Then in the onCreate state, an ArrayList of the type Movie, which has the constructor, getter,
	and setters in the Movie activity is created, later used using the MovieAdapter function to adapt it to a
	listview item inflated in the listview inside the MainActivity xml layout;

	Important!
		The urlArray provided to the request is a free hosted static url, not the url from the server, the
	url from the server did not work for me with any localhost ip I tried and really got stuck, but running the
	index will show a working json array. I have not yet figured out what the problem is.

	Using a volley requestqueue, a new request is added using a JsonArrayRequest, that uses a URL to request
	a json array and using the parseJSON method, the new jsonarray requested from the url is divided into jsonObjects
	which are later added as an object of type Movie to our movieList declared earlier with the setters transformed into
	string from the tags.

	After the adapter is created using the List of movies created after the json request using volley, and 
	the lisview is adapted using the adapter, a setOnItemClickListener method is called.
	The method is used to get the position of the current Movie from the list, using an intent between the
	MainActivity and the ListItem activity and a bundle that has sends the information from the current Movie object
	so that it can be displayed in the ListItem activity.

The second is the ListItem activity where:
	
	After the layout elementsare declared and attributed to each layout item in the xml, the bundle is declared
	to get the extra information from the Movie object that is selected and then set to the layout elements declared
	earlier.

The Movie activity is where:
	The getters and setters for the Movie object are declared.
	
The MovieAdapter activity extends ArrayAdapter of object type Movie
	
	The activity will have a constructor, that will get the context of the activity in which is used and an array list
	of the objects the adapter will adapt into the listview.
	
	Using the getView method, each list item layout will be inflated with information from the array list object
	
	The ViewHolder class is declared, where view elements are declared and in the getView method are inflated to each
	of the layout xml elements using the getter methods from the Movie object based on the position in the list;
