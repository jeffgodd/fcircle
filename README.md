# fcircle

Coding Challenge

## Installation

Clone from gitub 

## Usage

This app was build with the help of Leiningen.  https://leiningen.org/
Tests require Leiningen, running requires java.

This app takes an integer as input and prints a multiplication table of prime numbers with that number of columns.  It is reasonably performant to 100,000 or so,
but really needs something lazy rather than brute force for more primes than that.

    $ java -cp fcircle-0.1.0-standalone.jar clojure.main -m fcircle.core [args]

To run TESTs:

    $ lein test
    
## Options

Enter no arguments and you will receive a prompt.
Enter an integer and you receive a primes multiplication table. 
Enter an integer followed by the string "integer" and you receive a decimals multiplication table.


## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
