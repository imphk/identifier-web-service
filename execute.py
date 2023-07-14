import requests
import sys, os
import uuid

if len(sys.argv) > 1:
    id = sys.argv[1] #chave recebida do github ou uuid
else:
    id = uuid.uuid4().hex

PARAM = {'api_key': '903e368a-4f5d-445f-9b64-b4586519a388', 'id': id}

filename = 'marathon-' + id + '.zip'

#Upload
file_path = '/home/runner/work/identifier-web-service/identifier-web-service/' + filename
files = {'file':open(file_path, 'rb')}
response = requests.post("https://f807-2804-7f3-4b8f-b4b2-e6f0-3977-6ee5-111d.ngrok-free.app/api/upload", files=files, params=PARAM)
print(response.text)

response = requests.get("https://f807-2804-7f3-4b8f-b4b2-e6f0-3977-6ee5-111d.ngrok-free.app/api/run", params=PARAM)
print(response.text)

#Download
report_filename = 'report-' + id + '.zip'
response = requests.get("https://f807-2804-7f3-4b8f-b4b2-e6f0-3977-6ee5-111d.ngrok-free.app/api/download/report", params=PARAM)
open(report_filename, 'wb').write(response.content)
print(response)
