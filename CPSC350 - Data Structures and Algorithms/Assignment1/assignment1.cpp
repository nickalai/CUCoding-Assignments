/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 1
*/

#include "assignment1.h"

//constructor
dnaStrands::dnaStrands()
{

}

//destructor
dnaStrands::~dnaStrands()
{
  cout << "object deleted" << endl;
}

//takes in the input file and calculates statistics
void dnaStrands::calcStats(ifstream& f)
{
  string dna;
  int numStrands = 0;
  numChars = 0;
  int a = 0;
  int c = 0;
  int g = 0;
  int t = 0;
  int aa = 0;
  int ac = 0;
  int ag = 0;
  int at = 0;
  int ca = 0;
  int cc = 0;
  int cg = 0;
  int ct = 0;
  int ga = 0;
  int gc = 0;
  int gg = 0;
  int gt = 0;
  int ta = 0;
  int tc = 0;
  int tg = 0;
  int tt = 0;
  int totalBigrams = 0;
  //iterates through lines in the .txt file and counts up the amount of A, C, G, T, and bigrams.
  while(getline(f, dna))
  {
    int z = strlen(dna.c_str());
    numChars += z;
    for(int i = 0; i < z; ++i)
    {
      //uppers the line for consistency
      char char1 = toupper(dna.at(i));
      if(z == i + 1)
      {
        if(char1 = 'A')
          a++;
        else if(char1 = 'C')
          c++;
        else if(char1 = 'G')
          g++;
        else if(char1 = 'T')
          t++;
        break;
      }
      //uppers the line for consistency
      char char2 = toupper(dna.at(i+1));
      if (char1=='A' && char2=='A')
      {
        aa++;
				a++;
      }
			else if (char1=='A' && char2=='C')
      {
				ac++;
				c++;
			}
      else if (char1=='A' && char2=='G')
      {
				ag++;
				g++;
			}
      else if (char1=='A' && char2=='T')
      {
				at++;
				t++;
			}
      else if (char1=='C' && char2=='A')
      {
				ca++;
				a++;
			}
      else if (char1=='C' && char2=='C')
      {
				cc++;
				c++;
			}
      else if (char1=='C' && char2=='G')
      {
				cg++;
				g++;
			}
      else if (char1=='C' && char2=='T')
      {
				ct++;
				t++;
			}
      else if (char1=='G' && char2=='A')
      {
				ga++;
				a++;
			}
      else if (char1=='G' && char2=='C')
      {
				gc++;
				c++;
			}
      else if (char1=='G' && char2=='G')
      {
				gg++;
				g++;
			}
      else if (char1=='G' && char2=='T')
      {
				gt++;
				t++;
			}
      else if (char1=='T' && char2=='A')
      {
				ta++;
				a++;
			}
      else if (char1=='T' && char2=='C')
      {
				tc++;
				c++;
			}
      else if (char1=='T' && char2=='G')
      {
				tg++;
				g++;
			}
      else if (char1=='T' && char2=='T')
      {
				tt++;
				t++;
			}
			totalBigrams++;
		}
		numStrands++;
	}
  //subtracts the number of strands from the number of characters to avoid bug that adds number of lines to the number of characters
  numChars = numChars - numStrands;
  mean = (double)numChars / (double)numStrands;
  //calculates probabilities
  pA = a / (double)numChars;
  pC = c / (double)numChars;
  pG = g / (double)numChars;
  pT = t / (double)numChars;

  pAA = aa / (double)totalBigrams;
  pAC = ac / (double)totalBigrams;
  pAG = ag / (double)totalBigrams;
  pAT = at / (double)totalBigrams;
  pCA = ca / (double)totalBigrams;
  pCC = cc / (double)totalBigrams;
  pCG = cg / (double)totalBigrams;
  pCT = ct / (double)totalBigrams;
  pGA = ga / (double)totalBigrams;
  pGC = gc / (double)totalBigrams;
  pGG = gg / (double)totalBigrams;
  pGT = gt / (double)totalBigrams;
  pTA = ta / (double)totalBigrams;
  pTC = tc / (double)totalBigrams;
  pTG = tg / (double)totalBigrams;
  pTT = tt / (double)totalBigrams;

  cout << a << endl;
  cout << c << endl;
  cout << g << endl;
  cout << t << endl;

  //clears the input stream and relocates back to beginning of the stream
  f.clear();
  f.seekg(0, f.beg);

  //used to calculate standard deviation and variance
  double squareSum = 0.0;
  while(getline(f, dna))
  {
    int m = strlen(dna.c_str());
    double j = (double)m - (double)mean;
    double n = pow(j, 2.0);
    squareSum = squareSum + n;
  }

  variance = squareSum / (double)numStrands;
  stdDev = pow(variance, 0.5);
}

//writes results of calculations to the .out file
void dnaStrands::printStats(ofstream& output)
{
  output << "Name: Nick Lai" << "\n";
  output << "Student ID#: 2282417" << "\n";
  output << "Chapman email: lai137@mail.chapman.edu" << "\n";
  output << "Course and Section: 350-02" << "\n";
  output << "\n-- Statistics about the length of DNA strands --" << "\n";
  output << "Sum: " << numChars << "\n";
  output << "Mean: " << mean << "\n";
  output << "Variance: " << variance << "\n";
  output << "Standard Deviation: " << stdDev << "\n";
  output << "Probability of A: " << pA * 100 << "\n";
  output << "Probability of C: " << pC * 100 << "\n";
  output << "Probability of G: " << pG * 100 << "\n";
  output << "Probability of T: " << pT * 100 << "\n";
  output << "Probability of AA: " << pAA * 100 << "\n";
  output << "Probability of AC: " << pAC * 100 << "\n";
  output << "Probability of AG: " << pAG * 100 << "\n";
  output << "Probability of AT: " << pAT * 100 << "\n";
  output << "Probability of CA: " << pCA * 100 << "\n";
  output << "Probability of CC: " << pCC * 100 << "\n";
  output << "Probability of CG: " << pCG * 100 << "\n";
  output << "Probability of CT: " << pCT * 100 << "\n";
  output << "Probability of GA: " << pGA * 100 << "\n";
  output << "Probability of GC: " << pGC * 100 << "\n";
  output << "Probability of GG: " << pGG * 100 << "\n";
  output << "Probability of GT: " << pGT * 100 << "\n";
  output << "Probability of TA: " << pTA * 100 << "\n";
  output << "Probability of TC: " << pTC * 100 << "\n";
  output << "Probability of TG: " << pTG * 100 << "\n";
  output << "Probability of TT: " << pTT* 100 << "\n";
  output << "-- End of statistics --" << "\n";
  output << "\n";
}

//uses Gaussian Distribution to print 1000 randomly generated DNA strands
void dnaStrands::gaussianDistribution(ofstream& output)
{
  //given functions
  double gauA = ((double)rand() / (RAND_MAX));
  double gauB = ((double)rand() / (RAND_MAX));

  double gauC = (sqrt(-2 * log(gauA))) * (cos(2 * (M_PI) * gauB));
  double gauD = (stdDev * gauC) + mean;

  //iterates through and creates 1000 random strings of DNA
  for(int i = 0; i < 1000; ++i)
  {
    for(int j = 0; j < gauD; ++j)
    {
      double range = rand() % 100;
      if(range <= (pA * 100))
        output << "A";
      else if(range <= ((pC + pA) * 100))
        output << "C";
      else if(range <= ((pG + pC + pA) * 100))
        output << "G";
      else if(range <= 100)
        output << "T";
    }
    output << "\n";
  }
  output.close();
}
