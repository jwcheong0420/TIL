input_id = input('아이디를 입력해주세요.\n')

members = ['joowon', 'k8805']
for member in members:
	if member == input_id:
		print('Hello, ' + member + '!')
		import sys
		sys.exit()		# not to print "Who are you?"
print('Who are you?')