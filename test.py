import requests,json
def get_data():
	url='https://swapi.dev/api/planets/?format=json'
	res=[]
	count=0
	res_json=requests.get(url).json()
	res.extend(res_json['results'])
	while url:
		res_json=requests.get(url).json()
		res.extend(res_json['results'])
		url=res_json['next']
		count+=1
	print(count)

def calculations():
	planets=set()
	climate=set()
	with open('data.json', 'r') as f:
			res=json.loads(f.read())
	for planet in res:
		planets.add(planet['name'])
		for s in [x.strip() for x in planet['terrain'].split(',')]:
			climate.add(s)
	print(climate,len(climate))
calculations()

