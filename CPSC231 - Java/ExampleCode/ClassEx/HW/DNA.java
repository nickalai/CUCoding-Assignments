


public class DNA{


	//CONSTRUCTORS AND THINGS

	private string strand;

	public String complement()
	{
		return this.complement(this.strand);		
	}

	private String complement(String orig)
	{

		//Implement complement stuff here
	}


	public String reverseComplement()
	{
		return this.reverseComplement(this.strand);
	}

	private String reverseComplement(String orig)
	{
		StringBuilder build = new StringBuilder()
		build.append(orig);
		return  this.complement(build.reverse().toString());	
	}

	//OTHER STUFF

}
