ZapposInterview
===============
This is the project for Zappos Software Engineering College Intern position.

Problem Statement: test a simple application that allows a user to submit two inputs: N (desired # of products) and X (desired dollar amount). The application should take both inputs and leverage the Zappos API (http://developer.zappos.com/docs/api-documentation) to create a list of Zappos products whose combined values match as closely as possible to X dollars. For example, if a user entered 3 (# of products) and $150, the application would print combinations of 3 product items whose total value is closest to $150.

This is a console application build in java
Here is the algorithm for selecting the products given #number of products and total amount.

pseudocode:
-----------------------------------------------------------------------------------------------------------------------
selectedProducts[# of products] 
oldDiff=infinity

determineOptimumProducts(product[] subset, subsetLength, nextIndex)
  if(subsetLength==number of products)
    checkClosestSum(subset)
  else
    for( j = nextIndex; j < (total number of products ); j++  )
      subset[subsetLength] = productList[j];
	    determineOptimumProducts( subset, subsetLength + 1, j + 1);
	  end 
	end
end
checkClosestSum(subset)
  totalNewAmount=sum(subset.price);
  if oldDiff > (totalNewAmount - desired)
    oldDiff=totalNewAmount - desired
    selectedProducts=subset
---------------------------------------------------------------------------------------------------------------------

      
