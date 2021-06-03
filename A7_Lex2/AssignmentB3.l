%{
    int nlines,nwords,nchars,ndigits,nlower,nupper,nschars;
%}

%%
\n {nlines++;}
[\t ' '] {nwords++;nchars++;}
[0-9] {ndigits++;nchars++;}
[A-Z] {nupper++;nchars++;}
[a-z] {nlower++;nchars++;}
[!@#] {nschars++;nchars++;}

%%

int yywrap(){
    return 1;
}

int main(){
    yyin = fopen("input.txt","r");
    yylex();
    printf("No. of lines: %d\n",nlines+1);
	printf("No. of words: %d\n",nwords+1);
	printf("No. of digits: %d\n",ndigits);	
	printf("No. of characters: %d\n",nchars);
	printf("No. of uppercase: %d\n",nupper);
	printf("No. of lowercase: %d\n",nlower);
	printf("No. of special characters: %d\n",nschars); 
}
