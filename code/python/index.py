module = "main"

from human.woman import Woman

def run():
    kitty_rurk = Woman("Kitty Rurk", 0)
    alice_coul = Woman("Alice Coul", 20)
    riley_steele = Woman("Riley Steele", 25)

    v = 1
    for i in range(10):
        v += 1
        println(f"v: {v}")

    women = [kitty_rurk, alice_coul, riley_steele]
    for woman in women:
        try:
            if woman.age == 0:
                raise Exception(f"{woman.name} is too young")
            if woman.age <= 17:
                raise Exception(f"{woman.name} is not an adult")
            if woman.age >= 80:
                raise Exception(f"{woman.name} is too old")

            name_msg = f"Got woman named {woman.name} and {woman.age} old."
            println(msg=name_msg)
            woman.run()
        except Exception as e:
            println(msg=e)

def println(msg: str):
    print(msg)

if __name__ == "__main__":
    run()