package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.Person;
import seedu.address.model.item.field.Description;
import seedu.address.model.item.field.DisplayPicture;
import seedu.address.model.item.field.Email;
import seedu.address.model.item.field.Github;
import seedu.address.model.item.field.Major;
import seedu.address.model.item.field.Name;
import seedu.address.model.item.field.Phone;
import seedu.address.model.item.field.Time;
import seedu.address.model.item.field.University;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String dp;
    private final String name;
    private final String description;
    private final String phone;
    private final String email;
    private final String github;
    private final String university;
    private final String major;
    private final String from;
    private final String to;
    private final String cap;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("dp") String dp, @JsonProperty("name") String name,
                             @JsonProperty("description") String description,
                             @JsonProperty("phone") String phone, @JsonProperty("email") String email,
                             @JsonProperty("github") String github, @JsonProperty("university") String university,
                             @JsonProperty("major") String major, @JsonProperty("from") String from,
                             @JsonProperty("to") String to, @JsonProperty("cap") String cap) {
        this.dp = dp;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.github = github;
        this.university = university;
        this.major = major;
        this.from = from;
        this.to = to;
        this.cap = cap;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        dp = source.getDisplayPicture().toString();
        name = source.getName().toString();
        description = source.getDescription().toString();
        phone = source.getPhone().toString();
        email = source.getEmail().toString();
        github = source.getGithub().toString();
        university = source.getUniversity().toString();
        major = source.getMajor().toString();
        from = source.getFrom().toString();
        to = source.getTo().toString();
        cap = String.valueOf(source.getCap());
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     */
    public Person toModelType() throws IllegalValueException {
        if (dp == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DisplayPicture.class.getSimpleName()));
        }
        if (!DisplayPicture.isValidDisplayPicture(dp)) {
            throw new IllegalValueException(DisplayPicture.MESSAGE_CONSTRAINTS_FILE_TYPE);
        }
        final DisplayPicture modelDisplayPicture = new DisplayPicture(dp);

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Description.class.getSimpleName()));
        }
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (github == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Github.class.getSimpleName()));
        }
        if (!Github.isValidGithub(github)) {
            throw new IllegalValueException(Github.MESSAGE_CONSTRAINTS);
        }
        final Github modelGithub = new Github(github);

        if (university == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, University.class.getSimpleName()));
        }
        if (!University.isValidUniversity(university)) {
            throw new IllegalValueException(University.MESSAGE_CONSTRAINTS);
        }
        final University modelUniversity = new University(university);

        if (major == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Major.class.getSimpleName()));
        }
        if (!Major.isValidMajor(major)) {
            throw new IllegalValueException(Major.MESSAGE_CONSTRAINTS);
        }
        final Major modelMajor = new Major(major);

        if (from == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Time.class.getSimpleName()));
        }
        if (!Time.isValidTime(from)) {
            throw new IllegalValueException(Time.MESSAGE_CONSTRAINTS);
        }
        final Time modelFrom = new Time(from);

        if (to == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Time.class.getSimpleName()));
        }
        if (!Time.isValidTime(to)) {
            throw new IllegalValueException(Time.MESSAGE_CONSTRAINTS);
        }
        final Time modelTo = new Time(to);

        // Enforces that to does not precede from
        if (modelTo.compareTo(modelFrom) < 0) {
            throw new IllegalValueException("The \"to\" field must not precede the \"from\" field.");
        }

        final double modelCap;
        try {
            modelCap = Double.parseDouble(cap);
        } catch (NumberFormatException|NullPointerException e) {
            throw new IllegalValueException("The cap field must be a numeric value");
        }
        if (modelCap > 5 || modelCap < 0) {
            throw new IllegalValueException("The cap value must be between 0.0 and 5.0 inclusive.");
        }

        return new Person(modelDisplayPicture, modelName, modelDescription, modelPhone, modelEmail,
                modelGithub, modelUniversity, modelMajor, modelFrom, modelTo, modelCap);
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof JsonAdaptedPerson
                && dp.equals(((JsonAdaptedPerson) other).dp)
                && name.equals(((JsonAdaptedPerson) other).name)
                && description.equals(((JsonAdaptedPerson) other).description)
                && phone.equals(((JsonAdaptedPerson) other).phone)
                && email.equals(((JsonAdaptedPerson) other).email)
                && github.equals(((JsonAdaptedPerson) other).github)
                && university.equals(((JsonAdaptedPerson) other).university)
                && major.equals(((JsonAdaptedPerson) other).major)
                && from.equals(((JsonAdaptedPerson) other).from)
                && to.equals(((JsonAdaptedPerson) other).to)
                && cap.equals(((JsonAdaptedPerson) other).cap));
    }
}
