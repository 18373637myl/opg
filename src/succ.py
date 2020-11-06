import fileinput

s = '\n'.join(fileinput.input())
x = int(s)
print(x+1)
