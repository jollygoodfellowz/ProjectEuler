#!/usr/bin/env python
total = set()
setA = []
n = 101

for i in range (2,n):
	for j in range(2,n):
		setA.append(i**j)
	s1 = set(setA)
	total |= s1
	del setA[:]

print len(total)
