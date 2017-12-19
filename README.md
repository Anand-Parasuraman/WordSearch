# WordSearch

This project provides a service to search for single / multiple words across files that is preconfigured (Config.properties) also has flexibility in searching in specific file extensions.

As per the requirement, if multi-search term is provided, then all should be present in a file then only the result will have that file name.

The service (POST method) will support JSON as the messaging language. 

Resource URL : /search/words

Sample Request Body :
{
	"keyword" :  ["ABCD" , "EFGH"]
}
