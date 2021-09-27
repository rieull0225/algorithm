
total = []
hos = []
while(True):
    a = input()
    spl = a.split(':')
    if spl[0].strip() == '병원명':
        hos.append(spl[1].strip())
    elif spl[0].strip() == '원장':
        hos.append(spl[1].strip())
    elif spl[0].strip() == '주소':
        hos.append(spl[1].strip())
    elif spl[0].strip() == '번호' or spl[0].strip() == '전화번호':
        hos.append(spl[1].strip())
        total.append(hos)
        hos = []
    elif a == '*':
        break

print(total)