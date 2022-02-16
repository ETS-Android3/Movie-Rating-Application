import express from 'express';

const app = express();
const {MongoClient} = require('mongodb');

async function main(){
    /**
     * Connection URI. Update <username>, <password>, and <your-cluster-url> to reflect your cluster.
     * See https://docs.mongodb.com/ecosystem/drivers/node/ for more details
     */
    const url = "mongodb://127.0.0.1:27017";

    const dbName = 'movies'
    let db: any

    var findDocuments = function(db: any, callback: any) {
          // Get the documents collection
          var collection = db.collection('movies');
          // Find some documents
          collection.find().toArray(function(err: any, docs: any) {
            // assert.equal(2, docs.length);
            console.log("Found the following records");
            callback(docs);
            app.get('/movies', (req, res) => {
                res.json(docs);
            })
          });
        }

    MongoClient.connect(url, { useNewUrlParser: true }, (err: any, client: any) => {
      if (err) return console.log(err)
      db = client.db('movies')
      findDocuments(db, function(docs: any) {
          console.log(docs);
        });
    })

}

main().catch(console.error);

app.get('/', (req, res) => {
    res.send('This is a test web page!');
})

app.listen(3000, () => {
    console.log('The application is listening on port 3000!');
})