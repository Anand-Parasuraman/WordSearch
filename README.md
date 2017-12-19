# WordSearch

This project provides a service to search for single / multiple words across files that is preconfigured (Config.properties) also has flexibility in searching in specific file extensions.

As per the requirement, if multiple search terms are provided, then files containing all search terms only present in the response.

The service (POST method) will support JSON as the messaging language. 

Resource URL : /search/words

Sample Request Body :
{
	"keyword" :  ["ABCD" , "EFGH"]
}
