# -*- encoding:UTF-8 -*-
import  urllib.request
import  urllib
from chardet import detect 
import json  

def  search(url,page):
	query = {
		"key":"d9906f709e822ba01a01d7448ed32de7",
		"keywords":"加油站",
		"types":"加油站",
		"city":"福州",
		"children":"1",
		"offset":"20",
		"page":page,
		"extensions":"all"
	}

	urlencodedQuery = urllib.parse.urlencode(query)
	fp = urllib.request.urlopen(url+urlencodedQuery)
	mybytes = fp.read()
	# note that Python3 does not read the html code as string
	# but as html code bytearray, convert to string with
	# 判断编码
	print(detect(mybytes))

	mystr = mybytes.decode('utf-8')

	fp.close() 
	return mystr

url = "http://restapi.amap.com/v3/place/text?" 
 
for num in range(1,20):
	mystr = json.loads(search(url,num))
	fo = open("D:/python工作区/福州分页数据第"+str(num)+"页加油站.txt", "w")
	fo.write(json.dumps(mystr["pois"]))
	fo.close()
