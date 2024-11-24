from .human import Human

class Woman(Human):
    """
    sadsadsadsad
    sad
    sad
    asd
    sad
    sad
    sad
    sa
    dsa
    dsadsadasdsad
    """
    def __init__(self, name, age):
        super().__init__(name, age)
    
    def run(self) -> any:
        println(f"{self.name} is running")

def println(msg: str):
    print(msg)