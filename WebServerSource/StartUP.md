To start the server, first it is needed to start the mongodb server

To do so, the following commands have to be written in a cmd running as administrator

	cd ..\WebServerSource\mongodb_server\bin
	
	mongod.exe --dbpath "..\WebServerSource\mongodb_server\data"
	
	Now the mongo server will start
	
After the database server is running, the nodejs server has to be started using the following command in the
typescript-nodejs server:
	
	ts-node index.ts
	
	Doing so, the nodejs server will start and on http://localhost:3000/movies, the user will be able to see
the json parsed from the database

Now everything is running and the app can start.