#!/bin/bash
# Simulated Weekly Script That Iterates 5 Times

# Reset Bank Accounts | Reset Master Bank Accounts 
> bank.txt
> master_bank.txt
cp baseData/bank_data.txt bank.txt
cp baseData/master_bank_data.txt master_bank.txt

# Loop through all input files
for day_name in day*/; do

  # Clear Transaction File
  > master_transactn.txt;
  echo $day_name
  
  for file_name in $day_name*_in.txt; do
	  cp $file_name ${file_name#*/}
  done
  
  # Run Daily Script
  sh ./daily.sh
  
  for file_name in $day_name*_in.txt; do
	  : ${file_name#*/}
	  rm $_
	  rm ${_%*in.txt}transact.txt
  done
done
