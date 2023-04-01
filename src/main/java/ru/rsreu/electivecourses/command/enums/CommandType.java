package ru.rsreu.electivecourses.command.enums;

import ru.rsreu.electivecourses.command.*;
import ru.rsreu.electivecourses.command.admin.*;
import ru.rsreu.electivecourses.command.moderator.*;
import ru.rsreu.electivecourses.command.student.JoinCourseCommand;
import ru.rsreu.electivecourses.command.student.LeaveCourseCommand;
import ru.rsreu.electivecourses.command.student.ShowCourseInteractionsCommand;
import ru.rsreu.electivecourses.command.teacher.*;

import static ru.rsreu.electivecourses.constant.RoleCommandTypeConstantsKeeper.*;

public enum CommandType {

    LOGIN("login", LoginCommand.class, ALL_USERS_ACCESS_ROLE_ID),
    SHOW_LOGIN_PAGE("showLoginPage", ShowLoginPageCommand.class, ALL_USERS_ACCESS_ROLE_ID),
    LOGOUT("logout", LogoutCommand.class, ALL_USERS_ACCESS_ROLE_ID),
    RETURN_TO_MAIN_PAGE("returnToMain", ReturnToMainPageCommand.class, ALL_USERS_ACCESS_ROLE_ID),

    SHOW_REGISTRATION_NEW_USER_FORM("showRegistrationNewUser", ShowCreatingUserFormCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),
    CREATE_NEW_USER("createNewUser", CreateUserCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),
    SHOW_DELETING_USER_FORM("showDeletingUser", ShowDeletingUserFormCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),
    DELETE_USER("deleteUser", DeleteUserCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),
    EDIT_USER("editUser", EditUserCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),
    SHOW_EDITING_USER_FORM("showEditingUser", ShowEditingUserFormCommand.class, ADMINISTRATOR_ACCESS_ROLE_ID),

    SHOW_BLOCKING_USER_FORM("showBlockUser", ShowBlockUserFormCommand.class, MODERATOR_ACCESS_ROLE_ID),
    BLOCK_USER("blockUser", BlockUserCommand.class, MODERATOR_ACCESS_ROLE_ID),
    UNBLOCK_USER("unblockUser", UnblockUserCommand.class, MODERATOR_ACCESS_ROLE_ID),
    SHOW_DELETING_COURSE("showDeleteCourse", ShowDeletingCourseCommand.class, MODERATOR_ACCESS_ROLE_ID),
    DELETE_COURSE("deleteCourse", DeleteCourseCommand.class, MODERATOR_ACCESS_ROLE_ID),
    START_COURSE("startCourse", StartCourseCommand.class, MODERATOR_ACCESS_ROLE_ID),

    SHOW_CREATING_NEW_COURSE("showCreatingNewCourse", ShowCreatingCourseFormCommand.class, TEACHER_ACCESS_ROLE_ID),
    CREATE_NEW_COURSE("createNewCourse", CreateCourseCommand.class, TEACHER_ACCESS_ROLE_ID),
    SHOW_SETTING_GRADES("showSettingGrades", ShowSettingGradesCommand.class, TEACHER_ACCESS_ROLE_ID),
    SET_FINAL_MARK("setFinalGrade", SetFinalMarkCommand.class, TEACHER_ACCESS_ROLE_ID),
    SET_INTERMEDIATE_MARK("setIntermediateGrade", SetIntermediateMarkCommand.class, TEACHER_ACCESS_ROLE_ID),
    SHOW_SETTING_ATTENDANCE("showSettingAttendance", ShowSettingAttendanceCommand.class, TEACHER_ACCESS_ROLE_ID),
    SET_ATTENDANCE("setAttendance", SetAttendanceCommand.class, TEACHER_ACCESS_ROLE_ID),

    SHOW_COURSE_INTERACTIONS("showCourseInteractions", ShowCourseInteractionsCommand.class, STUDENT_ACCESS_ROLE_ID),
    JOIN_COURSE("joinCourse", JoinCourseCommand.class, STUDENT_ACCESS_ROLE_ID),
    LEAVE_COURSE("leaveCourse", LeaveCourseCommand.class, STUDENT_ACCESS_ROLE_ID);

    private String commandName;
    private Class<? extends Command> commandClass;
    private Long roleId;

    CommandType(String commandName, Class<? extends Command> commandClass, Long roleId) {
        this.commandName = commandName;
        this.commandClass = commandClass;
        this.roleId = roleId;
    }

    public static CommandType getCommandType(String commandName) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getCommandName().equals(commandName)) {
                return commandType;
            }
        }
        return CommandType.LOGIN;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public void setCommandClass(Class<? extends Command> commandClass) {
        this.commandClass = commandClass;
    }
}
