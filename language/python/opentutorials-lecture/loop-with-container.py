members = ['joowon', 'sconejam', 'june', 'yeni']

# while
print("print container with while loop")
i = 0
while i < len(members):
	print(members[i])
	i = i + 1

# for
print("print container with for loop")
for member in members:		# syntatic sugar
	print(member)

print("print 5 times with for loop using range(x, y)")
for i in range(5):			# range(5) == range(0, 5)
	print("Hello World!")