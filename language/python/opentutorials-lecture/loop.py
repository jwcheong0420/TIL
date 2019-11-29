while False:
	print("in while loop")
print("after while")

i = 0
while i < 10:
	if i == 4:
		print(i)
	i = i + 1
print("after while - i :" + str(i))
#print("after while - i :" + i)			# TypeError: can only concatenate str (not "int") to str

i = 0
while i < 10:
	if i == 4:
		break
	print(i)
	i = i + 1
print("after while - i :" + str(i))
