package ru.snm.misc.jdk10_builder;

import java.util.function.Consumer;

/**
 * @author sine-loco
 */
public final class FullBuilder {
    private Header header;
    private Body body;

    public FullBuilder header( Consumer<HeaderBuilder> chb ) {
        HeaderBuilder headerBuilder = new HeaderBuilder();
        chb.accept( headerBuilder );
        header = headerBuilder.build();
        return this;
    }

    public FullBuilder body( Consumer<BodyBuilder> cbb ) {
        BodyBuilder bodyBuilder = new BodyBuilder();
        cbb.accept( bodyBuilder );
        body = bodyBuilder.build();
        return this;
    }

    public Full build() {
        return new Full( header, body );
    }


    static final class HeaderBuilder {
        private String first;
        private String second;

        private HeaderBuilder() {}

        public HeaderBuilder first( String first ) {
            this.first = first;
            return this;
        }

        public HeaderBuilder second( String second ) {
            this.second = second;
            return this;
        }

        public Header build() {
            return new Header( first, second );
        }
    }


    static final class BodyBuilder {
        private BodyFirst first;
        private String second;

        private BodyBuilder() {}

        public BodyBuilder first( Consumer<BodyFirstBuilder> cbfb ) {
            BodyFirstBuilder bodyFirstBuilder = new BodyFirstBuilder();
            cbfb.accept( bodyFirstBuilder );
            this.first = bodyFirstBuilder.build();
            return this;
        }

        public BodyBuilder second( String second ) {
            this.second = second;
            return this;
        }

        public Body build() {
            return new Body( first, second );
        }


        static class BodyFirstBuilder {
            private String first;
            private String second;

            private BodyFirstBuilder() {}

            public BodyFirstBuilder first( String first ) {
                this.first = first;
                return this;
            }

            public BodyFirstBuilder second( String second ) {
                this.second = second;
                return this;
            }

            public BodyFirst build() {
                return new BodyFirst( first, second );
            }
        }
    }
}
