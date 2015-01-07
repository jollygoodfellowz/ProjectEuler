//
//  Trianglefinder
//  This program solves projectEuler number 12. The goal here is to find the first pythagorean triplet that has 500 divisors.
//

#include <stdio.h>
#include <math.h>
#include <time.h>

#define NUM_MULTIPLES 500

int triangleMultiples(int num);

int main()
{
  //Start the timer
  double time2, time1;
  time1 = clock();
  
  //Summation formula = the next triangle number i(i + 1)/2
  int i, multiples = 0, sum = 0;
  for(i = 1; multiples <= NUM_MULTIPLES; i++)
  {
    sum += i;
    multiples = triangleMultiples(sum);
  }
  
  printf("%d\n", sum);
  
  time2 = clock();
  printf("It took %lf seconds to find the first triangle number with 500 divisors\nThis was the %dth triangle\n", (time2 - time1)/ CLOCKS_PER_SEC, i);
  
  
  return 0;
  
}

//Pre condition: num is a summation of the next whole integer
//Post condition: the number of multiples from summation num are returned
int triangleMultiples(int num)
{
  if(num == 1)
    return 1;
  
  int i, count = 0, lowestMultiple = num/2;

  for(i = 2; i < lowestMultiple; i++)
    if(num % i == 0)
    {
      lowestMultiple = num/i;
      count++;
    }
  return (count*2)+2;
}
