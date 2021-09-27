import sys

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    arr0 = [1, 0, 1]
    arr1 = [0, 1, 1]
    for i in range(2,41):
        arr0.append(arr0[i-1]+arr0[i])
        arr1.append(arr1[i-1]+arr1[i])

    print(arr0[x],arr1[x])
