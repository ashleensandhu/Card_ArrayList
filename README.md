# Card_ArrayList
# This program primarily focuses on the implementation of a ArrayList type interface and the 
# necessary methods to implement the ArrayList. It also includes polymorphism and class 
# comparison. 
# While the primary goal of this assignment will be the implementation and use of a custom 
# For our card game, we will assume that every card has three values expressed as integers. Each  card will have three intrinsic values. These values will be labeled its R, S, P values. Each of 
# these will need to be monitored to be a minimum of 1 and a maximum of 1000. In addition Cards then have a calculated cost attribute that comes from how far apart the R, S, P values are from one another.
# Let 𝑋 be the sum of R,P and S : 𝑋 = 𝑅 + 𝑃 + 𝑆 
# A card with R= 5, S = 5, and P = 5 has a cost of 98. Which is the highest possible cost. A card with R= 1, S = 1, and P = 1000 has a cost of 2. A card with R= 1, S = 2, and P = 3 has a cost of 34.
# When comparing two cards, the one with the higher cost comes after the other unless they have the same cost. If the two cards have the same cost, then the one with the SMALLER sum of R,P,, S values comes first. If the cost is the same, and R+P+S is the same, then they are equal. 
# {1,1,1000::2} < {1,2,3::34} = {2,1,3::34} = {3,2,1::34} < {60,70,70::93} < {600,700,700::93} 
# I will construct an ArrayList that can manage a set of Cards which includes both normal and premium cards. I will implement the various methods that are required in order to make the ArrayList function.
