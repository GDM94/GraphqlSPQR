package com.example.springPostgres.resolver;

public class AnagraficaResolver {
}


@Component
public class AnagraficaResolver {

    @Autowired
    private IUserService userService;

    @GraphQLMutation(name="createUser")
    public User createUser(@GraphQLArgument(name="details") User user) {
        return userService.createUser(user);
    }

    @GraphQLQuery(name="getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GraphQLMutation(name="updateUser")
    public User updateUser(@GraphQLArgument(name="details") User user) {
        return userService.updateUser(user);
    }

    @GraphQLMutation(name="deleteUser")
    public Boolean deleteUser(@GraphQLArgument(name="userId") String id) {
        userService.deleteUser(id);
        return true;
    }

    @GraphQLQuery(name="getUser")
    public User getUser(@GraphQLArgument(name="userId") String id) {
        return userService.getUser(id);
    }


}