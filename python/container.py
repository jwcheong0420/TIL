# String
name = 'joowon'
print(type(name))

# List
names = ['joowon', 'sconejam', 'june', 'yeni']
print(type(names))
print(names)
print(names[0])

# Different data type of list elements
joowon = ['programmer', 'bundang', 27, False]
print(joowon)
joowon[1] = 'seoul'
print(joowon)

# library @python.org
print('seoul' in joowon)	# x in s
print(max(names))			# max(s), s contsists of data type elements
print(len(names))			# len(s), number of elements
names.reverse()				# s.reverse(), reverse items in list s
print(names)
names.append('jenny')		# s.append(x), add item x to list s
print(names)
del(names[4])				# del(s[i]), remove item s[i]
print(names)