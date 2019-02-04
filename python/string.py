print("=== String ===")
print('Hello')
print("Hello")
#print('Hello") #SyntaxError: EOL while scanning string literal
#print('Hello 'world'') #SyntaxError: invalid syntax
print("Hello 'world'")
print('Hello "world"')

print("=== String control ===")
print('Hello ' + 'world')
print('Hello '*3)
#print('Hello ' - 'world')  #TypeError: unsupported operand type(s) for -: 'str' and 'str'
print('Hello'[0])
print('Hello'[1])
print('Hello'[2])
print('Hello'[3])
print('Hello'[4])

print("=== String control2 ===")
print('hello world'.capitalize())
print('hello world'.upper())
print('hello world'.__len__())
print(len('hello world'))
print('hello world'.replace('world', 'programming'))

print("=== Escape character ===")
print("hello\tworld\n!\\\a")
print('hello\tworld\n!\\\a')

print("=== Number and String ===")
print("10+5 :", 10 + 5)
print("\"10\"+\"5\" : " + "10" + "5")
