import math

total = 1

def constraint(x1, x2, x3, x4, x5, x6, x7):
	
	ans = x1 + 2*x2 + 5*x3 + 10*x4 + 20*x5 + 50*x6 + 100*x7  
	if(ans > 200):
		return 2
	if(ans ==  200):
		return 0
	return 1

for x1 in range(201):

	test = constraint(x1,0,0,0,0,0,0)

	if test == 0:
		total = total +1
		break
	elif test == 2:
		break

	for x2 in range(101):
		
		test = constraint(x1,x2,0,0,0,0,0)

		if test == 0:	
			total = total +1
			break
		elif test == 2:
			break
		for x3 in range(41):

			test = constraint(x1,x2,x3,0,0,0,0)

			if test == 0:
				total = total +1
				break
			elif test == 2:
				break

			for x4 in range(21):

				test = constraint(x1,x2,x3,x4,0,0,0)
				
				if test == 0:
					total = total +1
					break
				elif test == 2:
					break	
				for x5 in range(11):
				
					test = constraint(x1,x2,x3,x4,x5,0,0)
					
					if test == 0:
						total = total +1
						break
					elif test == 2:
						break
					for x6 in range(5):

						test = constraint(x1,x2,x3,x4,x5,x6,0)

						if test == 0:
							total = total +1
							break
						elif test == 2:
							break	
						for x7 in range(3):

							test = constraint(x1,x2,x3,x4,x5,x6,x7)
							if test == 0:
								total = total + 1
								break
							elif test == 2:
								break
print(total)
