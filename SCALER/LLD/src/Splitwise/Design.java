package Splitwise;

public class Design {
    public static void main(String[] args){
        /*
        Split wise class diagram :-

        List of nouns :-
        1) User
        2) Group
        3) Expense
        4) Transactions

        This is a list of nouns which are potentially the working of this application.

        Here for the sake of understanding, we will use the term "paidBy" for the users those who
        paid at some place and the share of each user for that expense will be termed as "hadToPay".
        So an expense will contain this list of users that paid for the expense and list of users
        that hadToPay or share for that expense but here we are storing those amounts like this user-A
        paid 2000, user-B paid 1000 for this purpose, HashMap is better fit, so we will use two maps one
        for paidByMap and another for hadToPayMap.

        Here this application's class diagram is somewhat tricky as there are very limited number
        of classes and some functionality is not as straight forward as it seems.

        Let's encounter for the first thought process of settle up functionality.
        In this split wise application, we store expense and who paid what and who owes what and on the
        basis of that we decide how is the settle up process will take place.

        Expense splitting algorithm :-
        Let's say there are 4 members of a group, and they want to settle the amount, so here we will
        denote + as paid extra and - as need to pay so at the end
        A : +1750           B : -50
        D : -450            C : -1250

        Now how the payments should be done so that there is clean settlement amongst the users ? the
        simple answers would be, those who are supposed to receive some amount, should receive it from
        users who owe some amount, now the concern is that we want to achieve it in minimum number of
        transactions possible and for that, if the one owing highest amount, pays to the one who is the
        receiver of the highest amount, in this way with each transaction committed, at least one user
        is settled up and this can be achieved using heaps, just store all the data of users with owing
        money in the min heap and those with receiving amount user in the max heap and each iteration,
        take the absolute of both the min and max amount and subtract the min amount from the max amount
        and delete the user which have 0 transaction required to get settled.

        The settlement algorithm seems fine, but we are not sure that all the users will settle the
        amount as settle-up shows up, and so the transactions will change as the expenses are added or
        a transaction is settled, and so we don't need these transactions to be stored in database as we
        don't intend to retrieve it later after it is settled, and we are only asked to store the history
        of expenses made by a user, and so, one can fetch the list of expenses they made in the past .

        This application is only meant for keep the track of expenses and what is share of each person
        whether its already paid or had to pay, and when some user clicks for settle up, all the minimum
        number of transactions are calculated according to the number of users unsettled amount, and so
        we have no use of storing it in database or creating a separate class Transaction.

        The solution for this can be a dummy expense or a settlementExpense, means with the help of that
        settlement algorithm, at each iteration we are at least settling a single user, and so if we store
        it in terms of some separate class transaction, then it would be cumbersome task to track the
        settled expenses, and so we will create a dummy expense and the intuition behind it is, consider
        if user1 paid an amount of 500 rs on behalf of user2, so next time, user2 pays 500 on behalf of
        user1 and so the overall expense is settled. Sir called it as DummyExpense, but I will call it as
        SettledExpense.

        class User {
            id
            name
            phone
            password
        }

        Now the question is, do we need to create separate class settledExpense that only stores the data
        for the settled expense ? not really as we are storing exactly similar data that for a normal expense
        so no need for a separate class for SettledExpense we can just include an enum ExpenseType with values
        NORMAL expense and SETTLED expense.

        class Expense {                         enum ExpenseType {
            id                                      ACTUAL
            description                             SETTLED
            totalAmount                         }
            paidByMap<User, Integer>
            hadToPayMap<User, Integer>
            ExpenseType
            createdBy
        }

        For the group class what is the better way to express the relation between Expense and Group
        like one way is to add Group_id in Expense class or add list<Expense> in Group class so which
        is better ? in order to decide, consider the following scenarios, if the group_id is null in
        Expense class that means it is individual Expense and also there the most common operation here
        is to check expenses in group not an expense belongs to which group, so add List<Expense> in
        Group class.

        class Group {
            id
            name
            admin
            List<User>
            List<Expense>
        }

        Now there is another problem that is related to maps, how will we represent maps in
        database table ? second thing is that this kind of map are static data structures as
        once data type is determined, it cannot be changed, or we need to change the database table
        as well, like in future if we want to give the support of currency in which the payment
        was done, then we need to modify the whole database as well, so in terms of future proofing
        this is not the correct approach, or it is not extensible, instead we need to declare it
        as a class and that can be of two types
        1) ExpenseUserPaidBy
        2) ExpenseUserHadToPay

        class ExpenseUserPaidBy {           class ExpenseUserHadToPay {
            expense                             expense
            User                                User
            amount                              amount
        }                                   }

        now we can include the List<ExpenseUserPaidBy> and the List<ExpenseUserHadToPay> so that we
        can represent it terms of relation in database table, so it there is a user in an expense who
        paid somewhere, then it is included in the ExpenseUserPaidBy and stored in the corresponding
        list inside Expense class.

        These classes are indeed solving the problem, but it also brought some redundant class here
        like these both class have everything in common then how they can be different ? so we need to
        combine them under one class as ExpenseUser

        class ExpenseUser {             enum ExpenseType {
            expense                         PaidBy
            User                            HadToPay
            totalAmount                 }
            ExpenseType
        }

        So at the end we have these classes in the class diagram
        1) User
        2) Group
        3) Expense
        4) ExpenseUser
        5) ExpenseType

        In this case-study, in one way there is a lot that can be considered, but there is hardly
        some part that can be important in terms of interview.
        -----------------------------------------------------------------------------------------------

        Schema Design :-
        Rule to create schema from class diagram :-
        Create the table for each of the class and take the all the primitive attributes as it is and
        find the cardinalities for non-primitives.

        So from the class diagram first take all the classes and make them as database entity.

        In users table all the attributes are primitive attributes, so we can represent them as it
        is.
        Users {
            id
            name
            phone
            password
        }

          1                   M
        Group ------------ Expense ====> 1 : M
          1                   1

        Groups {
            id
            name
            admin_id

        }

        Here in expenses table, most of the attributes are primitive, there is a list of ExpenseUser,
        so we need to find the cardinality between them,

            1                  M
        Expense --------- ExpenseUser ====> 1 : M
            1                  1

            1                   1
        Expense ----------- ExpenseType ====> M : 1
            M                   1

            1                  1
        Expense ------------ User ====> M : 1
            M                  1
        Expenses {
            id
            description
            totalAmount
            expense_type_id
            created_by_id
            group_id    <------------ This is not needed actually as in some cases this is
                                        going to be null, so it will be a case of sparse relation
        }                               so create mapping table in such cases

        GroupExpense {
            id
            group_id
            expense_id


            1                    1
        ExpenseUser ---------- User ====> M : 1
            M                    1

        Expense-Users {
            id
            user_id
            expense_id
            amount
        }


        expense-type {
            id
            value
        }

        expense_user_type {
            id
            value
        }

        */
    }
}
